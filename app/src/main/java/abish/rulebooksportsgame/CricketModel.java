package abish.rulebooksportsgame;

/**
 * Created by helixtech-android on 30/6/16.
 */
public class CricketModel {
    int unique;
    String team,rank,matches,points,last_updated_date;

    public CricketModel(){}

    public int getUnique(){
        return unique;
    }
    public String getTeam(){
        return team;
    }
    public String getRank(){
        return rank;
    }
    public String getMatches(){
        return matches;
    }
    public String getPoints(){
        return points;
    }
    public String getLastUpdatedDate(){
        return last_updated_date;
    }

    public void setUnique(int val){
        this.unique=val;
    }
    public void setTeam(String val){
        this.team=val;
    }
    public void setRank(String val){
        this.rank=val;
    }
    public void setMatches(String val){
        this.matches=val;
    }
    public void setPoints(String val){
        this.points=val;
    }
    public void setLastUpdatedDate(String val){
        this.last_updated_date=val;
    }

}
