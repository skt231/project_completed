package com.drug.dto;

public class AdminDto {
   String id;
   String pw;
   int ad_num;
   
   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ad_num;
      result = prime * result + ((id == null) ? 0 : id.hashCode());
      result = prime * result + ((pw == null) ? 0 : pw.hashCode());
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
      AdminDto other = (AdminDto) obj;
      if (ad_num != other.ad_num)
         return false;
      if (id == null) {
         if (other.id != null)
            return false;
      } else if (!id.equals(other.id))
         return false;
      if (pw == null) {
         if (other.pw != null)
            return false;
      } else if (!pw.equals(other.pw))
         return false;
      return true;
   }
   public String getId() {
      return id;
   }
   public void setId(String id) {
      this.id = id;
   }
   public String getPw() {
      return pw;
   }
   public void setPw(String pw) {
      this.pw = pw;
   }
   public int getAd_num() {
      return ad_num;
   }
   @Override
   public String toString() {
      return "AdminDto [id=" + id + ", pw=" + pw + ", ad_num=" + ad_num + "]";
   }
   public void setAd_num(int ad_num) {
      this.ad_num = ad_num;
   }
   public AdminDto() {}
   public AdminDto(String id, String pw, int ad_num) {
      super();
      this.id = id;
      this.pw = pw;
      this.ad_num = ad_num;
   }
}