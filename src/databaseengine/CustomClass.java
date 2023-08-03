package databaseengine;

public class CustomClass {
    private int number;
    private int round1;
    private int round2;
    private int round3;
    private int round4;
    private int score;
    private String name;
   static int max ,result;
    // Getter method for the "number" field
    public int getNumber() {
        return number;
    }

    // Setter method for the "number" field
    public void setNumber(int number) {
        this.number = number;
    }

    // Getter method for "round1" field
    public int getRound1() {
        return round1;
    }

    // Setter method for "round1" field
    public void setRound1(int round1) {
        this.round1 = round1;
    }

    // Getter method for "round2" field
    public int getRound2() {
        return round2;
    }

    // Setter method for "round2" field
    public void setRound2(int round2) {
        this.round2 = round2;
    }

    // Getter method for "round3" field
    public int getRound3() {
        return round3;
    }

    // Setter method for "round3" field
    public void setRound3(int round3) {
        this.round3 = round3;
    }

    // Getter method for "round4" field
    public int getRound4() {
        return round4;
    }

    // Setter method for "round4" field
    public void setRound4(int round4) {
        this.round4 = round4;
    }

    // Getter method for the "score" field
    public int getScore() {
        return score;
    }

    // Setter method for the "score" field
    public void setScore(int score) {
        this.score = score;
    }

    // Getter method for the "name" field
    public String getName() {
        return name;
    }

    // Setter method for the "name" field
    public void setName(String name) {
        this.name = name;
    }

    // toString method to provide a string representation of the class
    @Override
    public String toString() {
        return "CustomClass: [Number=" + number +
                ", Round1=" + round1 +
                ", Round2=" + round2 +
                ", Round3=" + round3 +
                ", Round4=" + round4 +
                ", Score=" + score +
                ", Name='" + name + "']";
    }
    
    public int indexcount(java.util.List<CustomClass> cldata2)
    {
        result=0;
        number=0;
        max=-2;
        

        cldata2.forEach(e->{
            //System.out.println("score :"+e.getScore());
        if(e.getScore()>max)
        {
          max=e.getScore();
          result=number;
        }
        else
        {
            
        }
        number++;
        });
        
        return result;
    }
    public int indexcountmin(java.util.List<CustomClass> cldata2)
    {
        result=0;
        number=0;
        max=9999999;
        

        cldata2.forEach(e->{
            //System.out.println("score :"+e.getScore());
        if(e.getScore()<max)
        {
          max=e.getScore();
          result=number;
        }
        else
        {
            
        }
        number++;
        });
        
        return result;
    }
    public int classretrieve(java.util.List<CustomClass> cldata2)
    {
  
        return 223;
    }
}
