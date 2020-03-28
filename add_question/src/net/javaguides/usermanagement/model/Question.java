package net.javaguides.usermanagement.model;

public class Question {
    protected String question;
    protected int question_no;
  
    
	public Question() {
	}
	
	public Question(String question) {
		super();
		this.question= question;
		
	}

	public Question(int question_no, String question) {
		super();
		this.question_no=question_no;
		this.question =question;
		
	}

	public int getquestion_no() {
        return question_no;
    }
    public void setquestion_no(int question_no) {
        this.question_no =question_no;
    }
    public String getquestion() {
        return question;
    }
    public void setquestion(String question) {
        this.question= question;
    }
    
}
