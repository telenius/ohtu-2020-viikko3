
package ohtu;

public class Player implements Comparable<Player>{
	
	// goals :0
	// assists :1
	// name :"Jack Studnicka"
	// penalties :2
	// team :"BOS"
	// nationality :"CAN"
	// birthdate :"1999-02-18"
	
    private int goals;
    private int assists;
    private String name;
    private int penalties;
    private String team;
    private String nationality;
    private String birthdate;
    private int points;

    
    // ---------------------------------
    public void setGoals(int goals) {
        this.goals = goals;
    }
    public int getGoals() {
        return goals;
    }
    // ---------------------------------
    public void setAssists(int assists) {
        this.assists = assists;
    }
    public int getAssists() {
        return assists;
    }
    // ---------------------------------
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    // ---------------------------------
    public void setPenalties(int penalties) {
        this.penalties = penalties;
    }
    public int getPenalties() {
        return penalties;
    }
    // ---------------------------------
    public void setTeam(String team) {
        this.team = team;
    }
    public String getTeam() {
        return team;
    }
    // ---------------------------------
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    public String getNationality() {
        return nationality;
    }
    // ---------------------------------
    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }
    public String getBirthdate() {
        return birthdate;
    }
    // ---------------------------------  
    public void setPoints() {
        this.points = this.goals + this.assists;
    }
    public int getPoints() {
        return points;
    }
    // ---------------------------------  

    @Override
    public String toString() {
        
    	String nametulostus = String.format("%-20s", name);
    	String goaltul = String.format("%3s", goals);
    	String assiststul = String.format("%3s", assists);
    	String pointstul = String.format("%3s", points);
    	
    	return nametulostus + "\t" + team + "\t" + goaltul + "  + " + assiststul + "  = " + pointstul;
        
    	// goals :0
    	// assists :1
    	// name :"Jack Studnicka"
    	// penalties :2
    	// team :"BOS"
    	// nationality :"CAN"
    	// birthdate :"1999-02-18"
        
    }
      
    @Override
    public int compareTo(Player anotherplayer) {
        int otherpoints=anotherplayer.getPoints();
        return otherpoints-this.getPoints();

    }
}
