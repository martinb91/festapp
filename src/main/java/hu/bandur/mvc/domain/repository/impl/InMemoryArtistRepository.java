package hu.bandur.mvc.domain.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.text.html.HTMLEditorKit.Parser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import hu.bandur.mvc.domain.repository.ArtistRepository;
import hu.bandur.mvc.data.entities.*;

@Repository
public class InMemoryArtistRepository implements ArtistRepository {
	
	private List<Artist> listOfArtist;
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public List<Artist> getAllArtists() {
		Map<String, Object> params = new HashMap<String, Object>();
		List<Artist> result = jdbcTemplate.query("SELECT * FROM ARTISTS", params, new ArtistMapper());
		List<MusicStyle> result2 = jdbcTemplate.query("SELECT * FROM MUSICSTYLES", params, new MusicStyleMapper());
		result.get(1).setMusicStyleList(result2);
		return result;
	}

	private static final class ArtistMapper implements RowMapper<Artist> {
		public Artist mapRow(ResultSet rs, int rowNum) throws SQLException {
			Artist artist = new Artist(1);
			artist.setId(rs.getInt("ID"));
			artist.setName(rs.getString("NAME"));
			artist.setDescription(rs.getString("DESCRIPTION"));
			return artist;
		}
	}
	
	private static final class MusicStyleMapper implements RowMapper<MusicStyle> {
		public MusicStyle mapRow(ResultSet rs, int rowNum) throws SQLException {
			MusicStyle artist = new MusicStyle(1);
			artist.setId(rs.getInt("ID"));
			artist.setStyle(rs.getString("STYLE"));
			return artist;
		}
	}

	public void addArtist(Artist a) {
		
		String SQL = "INSERT INTO ARTISTS (ID, NAME, DESCRIPTION) "
				+ "VALUES (:id, :name, :desc)" ;
		
		 Map<String, Object> params = new HashMap<>();
         params.put("id", a.getId());  
         params.put("name", a.getName());  
         params.put("desc", a.getDescription());
         
         jdbcTemplate.update(SQL, params);
	}

	@Override
	public Artist getArtistById(String sid) {
		int id = -1;
		Map<String, Object> params = new HashMap<String, Object>();
		List<MusicStyle> musicStyleList=null;
		try {
			id = Integer.parseInt(sid);
			params.put("id", id);
		} catch (Exception e) {
			System.out.println("NaN exception");
		}

		
		List<Artist> artistByID = null;
		artistByID =jdbcTemplate.query("SELECT * FROM ARTISTS WHERE id = :id", params, new ArtistMapper());
		artistByID.get(0).setMusicStyleList(musicStyleList);
		
		if (artistByID == null) {
			throw new IllegalArgumentException("No artists found with this id: " + id);
		}

		return artistByID.get(0);
	}
	
	@Override
	public Artist getArtistByName(String name) {
		Artist artistByName = null;
		for (Artist a : listOfArtist) {
			if (a != null && a.getName() != null && a.getName().equals(name)) {
				artistByName = a;
				break;
			}
		}

		if (artistByName == null) {
			throw new IllegalArgumentException("No artists found with the name: " + name);
		}

		return artistByName;
	}

	@Override
	public List<Artist> getArtistsByCategory(String category) {
		List<Artist> artistsByCategory = new ArrayList<Artist>();
		for (Artist a : listOfArtist) {
			for (MusicStyle ms : a.getMusicStyleList()) {
				if (ms.getStyle().equals(category)) {
					artistsByCategory.add(a);
					break;
				}
			}
		}
		return artistsByCategory;
	}

	public Set<Artist> getArtistsByFilter(Map<String, List<String>> filterParams) {
		Set<Artist> artistsByName = new HashSet<Artist>();
		Set<Artist> artistsByCategory = new HashSet<Artist>();
		Set<String> criterias = filterParams.keySet();
		// System.out.println(criterias.isEmpty());
		if (criterias.contains("name")) {
			for (String name : filterParams.get("name")) {
				for (Artist artist : listOfArtist) {
					if (name.equalsIgnoreCase(artist.getName())) {
						artistsByName.add(artist);
					}
				}
			}
		}

		if (criterias.contains("category")) {
			for (String category : filterParams.get("category")) {
				artistsByCategory.addAll(this.getArtistsByCategory(category));
			}
		}

		artistsByCategory.retainAll(artistsByName);

		return artistsByCategory;
	}
}
