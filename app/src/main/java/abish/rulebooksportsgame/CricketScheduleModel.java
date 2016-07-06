package abish.rulebooksportsgame;

/**
 * Created by helixtech-android on 30/6/16.
 */
public class CricketScheduleModel {
    String series_name,home_team,opposition_team,match_description,match_date,venue,latitude,
            longitude,broadcasting_channel,local_time,gmt_time,ist_time,game_format,gender,last_updated_date;

    public CricketScheduleModel(){}

    public String getSeriesName(){
        return series_name;
    }
    public String getHomeTeam(){
        return home_team;
    }
    public String getOppositionTeam(){
        return opposition_team;
    }
    public String getMatchDescription(){
        return match_description;
    }
    public String getMatchDate(){
        return match_date;
    }
    public String getVenue(){
        return venue;
    }
    public String getLatitude(){
        return latitude;
    }
    public String getLongitude(){
        return longitude;
    }
    public String getBroadcastingChannel(){
        return broadcasting_channel;
    }
    public String getLocalTime(){
        return local_time;
    }
    public String getGmtTime(){
        return gmt_time;
    }
    public String getIstTime(){
        return ist_time;
    }
    public String getGameFormat(){
        return game_format;
    }
    public String getGender(){
        return gender;
    }
    public String getLastUpdatedDate(){
        return last_updated_date;
    }

    public void setSeriesName(String val){
        this.series_name=val;
    }
    public void setHomeTeam(String val){
        this.home_team=val;
    }
    public void setOppositionTeam(String val){
        this.opposition_team=val;
    }
    public void setMatchDescription(String val){
        this.match_description=val;
    }
    public void setMatchDate(String val){
        this.match_date=val;
    }
    public void setVenue(String val){
        this.venue=val;
    }
    public void setLatitude(String val){
        this.latitude=val;
    }
    public void setLongitude(String val){
        this.longitude=val;
    }
    public void setBroadcastingChannel(String val){
        this.broadcasting_channel=val;
    }
    public void setLocalTime(String val){
        this.local_time=val;
    }
    public void setGmtTime(String val){
        this.gmt_time=val;
    }
    public void setIstTime(String val){
        this.ist_time=val;
    }
    public void setGameFormat(String val){
        this.game_format=val;
    }
    public void setGender(String val){
        this.gender=val;
    }
    public void setLastUpdatedDate(String val){
        this.last_updated_date=val;
    }

}
