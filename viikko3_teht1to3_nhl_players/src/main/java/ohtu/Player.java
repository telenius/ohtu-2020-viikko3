
package ohtu;

public class Player {
	
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

    @Override
    public String toString() {
        return name + " team " + team + " " + goals + " " + assists;
        
    	// goals :0
    	// assists :1
    	// name :"Jack Studnicka"
    	// penalties :2
    	// team :"BOS"
    	// nationality :"CAN"
    	// birthdate :"1999-02-18"
        
    }
      
}
