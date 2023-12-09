package com.booking.dto;

import java.sql.Date;
import java.util.List;

public class RsvDto {
	private Integer userid;
	private String re_username;
	private List<String> re_selectedSeats;
	private Long re_totalAmount;
	private String re_mt20id;
	private Date re_showdate;
	private String re_location;
	private String re_time;
	private String re_title;

	RsvDto() {
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getRe_username() {
		return re_username;
	}

	public void setRe_username(String re_username) {
		this.re_username = re_username;
	}

	public List<String> getRe_selectedSeats() {
		return re_selectedSeats;
	}

	public void setRe_selectedSeats(List<String> re_selectedSeats) {
		this.re_selectedSeats = re_selectedSeats;
	}

	public Long getRe_totalAmount() {
		return re_totalAmount;
	}

	public void setRe_totalAmount(Long re_totalAmount) {
		this.re_totalAmount = re_totalAmount;
	}

	public String getRe_mt20id() {
		return re_mt20id;
	}

	public void setRe_mt20id(String re_mt20id) {
		this.re_mt20id = re_mt20id;
	}

	public Date getRe_showdate() {
		return re_showdate;
	}

	public void setRe_showdate(Date re_showdate) {
		this.re_showdate = re_showdate;
	}

	public String getRe_location() {
		return re_location;
	}

	public void setRe_location(String re_location) {
		this.re_location = re_location;
	}

	public String getRe_time() {
		return re_time;
	}

	public void setRe_time(String re_time) {
		this.re_time = re_time;
	}

	@Override
	public String toString() {
		return "RsvDto [userid=" + userid + ", re_username=" + re_username + ", re_selectedSeats=" + re_selectedSeats
				+ ", re_totalAmount=" + re_totalAmount + ", re_mt20id=" + re_mt20id + ", re_showdate=" + re_showdate
				+ ", re_location=" + re_location + ", re_time=" + re_time + ", re_title=" + re_title + "]";
	}

	public RsvDto(Integer userid, String re_username, List<String> re_selectedSeats, Long re_totalAmount,
			String re_mt20id, Date re_showdate, String re_location, String re_time, String re_title) {
		super();
		this.userid = userid;
		this.re_username = re_username;
		this.re_selectedSeats = re_selectedSeats;
		this.re_totalAmount = re_totalAmount;
		this.re_mt20id = re_mt20id;
		this.re_showdate = re_showdate;
		this.re_location = re_location;
		this.re_time = re_time;
		this.re_title = re_title;
	}

	public String getRe_title() {
		return re_title;
	}

	public void setRe_title(String re_title) {
		this.re_title = re_title;
	};

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((re_location == null) ? 0 : re_location.hashCode());
		result = prime * result + ((re_mt20id == null) ? 0 : re_mt20id.hashCode());
		result = prime * result + ((re_selectedSeats == null) ? 0 : re_selectedSeats.hashCode());
		result = prime * result + ((re_showdate == null) ? 0 : re_showdate.hashCode());
		result = prime * result + ((re_time == null) ? 0 : re_time.hashCode());
		result = prime * result + ((re_title == null) ? 0 : re_title.hashCode());
		result = prime * result + ((re_totalAmount == null) ? 0 : re_totalAmount.hashCode());
		result = prime * result + ((re_username == null) ? 0 : re_username.hashCode());
		result = prime * result + ((userid == null) ? 0 : userid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RsvDto other = (RsvDto) obj;
		if (re_location == null) {
			if (other.re_location != null)
				return false;
		} else if (!re_location.equals(other.re_location))
			return false;
		if (re_mt20id == null) {
			if (other.re_mt20id != null)
				return false;
		} else if (!re_mt20id.equals(other.re_mt20id))
			return false;
		if (re_selectedSeats == null) {
			if (other.re_selectedSeats != null)
				return false;
		} else if (!re_selectedSeats.equals(other.re_selectedSeats))
			return false;
		if (re_showdate == null) {
			if (other.re_showdate != null)
				return false;
		} else if (!re_showdate.equals(other.re_showdate))
			return false;
		if (re_time == null) {
			if (other.re_time != null)
				return false;
		} else if (!re_time.equals(other.re_time))
			return false;
		if (re_title == null) {
			if (other.re_title != null)
				return false;
		} else if (!re_title.equals(other.re_title))
			return false;
		if (re_totalAmount == null) {
			if (other.re_totalAmount != null)
				return false;
		} else if (!re_totalAmount.equals(other.re_totalAmount))
			return false;
		if (re_username == null) {
			if (other.re_username != null)
				return false;
		} else if (!re_username.equals(other.re_username))
			return false;
		if (userid == null) {
			if (other.userid != null)
				return false;
		} else if (!userid.equals(other.userid))
			return false;
		return true;
	}

}
