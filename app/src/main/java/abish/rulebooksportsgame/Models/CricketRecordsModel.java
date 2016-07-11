package abish.rulebooksportsgame.Models;

/**
 * Created by helixtech-android on 30/6/16.
 */
public class CricketRecordsModel {
    int unique;
    String title,rank,player,home_team,opposition_team,overs,maidens,runs,wickets,economy,match_date,venue,score,run_rate,innings,
            game_format,gender,last_updated_date;

    public CricketRecordsModel(){}

    public int getUnique
            (){
        return unique;
    }
    public String getRank(){
        return rank;
    }
    public String getTitle(){
        return title;
    }
    public String getPlayer(){
        return player;
    }
    public String getHomeTeam(){
        return home_team;
    }
    public String getOppositionTeam(){
        return opposition_team;
    }
    public String getOvers(){
        return overs;
    }
    public String getMatchDate(){
        return match_date;
    }
    public String getVenue(){
        return venue;
    }
    public String getMaidens(){
        return maidens;
    }
    public String getRuns(){
        return runs;
    }
    public String getWickets(){
        return wickets;
    }
    public String getEconomy(){
        return economy;
    }
    public String getScore(){
        return score;
    }
    public String getRunRate(){
        return run_rate;
    }
    public String getInnings(){
        return innings;
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

    public void setUnique(int val){
        this.unique=val;
    }
    public void setRank(String val){
        this.rank=val;
    }
    public void setTitle(String val){
        this.title=val;
    }
    public void setPlayer(String val){
        this.player=val;
    }
    public void setHomeTeam(String val){
        this.home_team=val;
    }
    public void setOppositionTeam(String val){
        this.opposition_team=val;
    }
    public void setOvers(String val){
        this.overs=val;
    }
    public void setMatchDate(String val){
        this.match_date=val;
    }
    public void setVenue(String val){
        this.venue=val;
    }
    public void setMaidens(String val){
        this.maidens=val;
    }
    public void setRuns(String val){
        this.runs=val;
    }
    public void setWickets(String val){
        this.wickets=val;
    }
    public void setEconomy(String val){
        this.economy=val;
    }
    public void setScore(String val){
        this.score=val;
    }
    public void setRunRate(String val){
        this.run_rate=val;
    }
    public void setInnings(String val){
        this.innings=val;
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
