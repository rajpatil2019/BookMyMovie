package com.ticket.booking.platform.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ticket.booking.platform.dto.ShowDetailsDTO;

@Repository
public class MyRepository {

	@Autowired
	private JdbcTemplate jtm;
	
	String showDetailsQuery="select city.name,cinema.name,show.id,show.date_time,show.start_time,show.end_time \n"
			+ "from city city \n"
			+ "inner join cinema cinema on cinema.city_id=city.city_id \n"
			+ "inner join cinema_hall ch on ch.cinema_id=cinema.cinema_id \n"
			+ "inner join show show on show.cinema_hall_id=ch.id \n"
			+ "where city.name="+"'Bangalore'";
	
	public List<ShowDetailsDTO> getShowDetailsDTO(String name){
		return jtm.query(showDetailsQuery, new RowMapper<ShowDetailsDTO>() {

			@Override
			public ShowDetailsDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				ShowDetailsDTO dto=new ShowDetailsDTO();
				dto.setCityName(rs.getString(1));
				dto.setCinemaName(rs.getString(2));
				dto.setShowId(Long.parseLong(rs.getString("id")));
				dto.setShowDate(rs.getString("date_time"));
				dto.setShowSatrtTime(rs.getString("start_time"));
				dto.setShowEndTime(rs.getString("end_time"));
				return dto;
			}
		});
	}
}