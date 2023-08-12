package com.rdschool.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.rdschool.db.ConnectionFactory;
import com.rdschool.entity.CourseEntity;
import com.rdschool.entity.ManagerEntity;
import com.rdschool.entity.NoteEntity;
import com.rdschool.entity.VideoEntity;

public class VideoDao {

	public boolean addVideo(VideoEntity n) throws Exception {
		boolean f = false;
		
		Connection conn = ConnectionFactory.getDbConn();

		try {
			String sql = "insert into video_details(videoname,videopath,coursename) values(?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,n.getVideoname());
			ps.setString(2,n.getVideopath());
			ps.setString(3, n.getCoursename());

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}
	
	
	public List<VideoEntity> getAllVideo() throws Exception {
		Connection conn = ConnectionFactory.getDbConn();
		List<VideoEntity> list = new ArrayList<VideoEntity>();
		VideoEntity n = null;

		try {
			String sql = "select * from video_details order by id desc";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				n = new VideoEntity();
				n.setId(rs.getInt(1));
			n.setVideoname(rs.getString(2));
			n.setVideopath(rs.getString(3));
			n.setCoursename(rs.getString(4));
				list.add(n);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	
}
