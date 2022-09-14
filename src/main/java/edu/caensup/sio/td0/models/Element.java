package edu.caensup.sio.td0.models;

public class Element {

	private String nom;
	private int evaluation;
	public static int max = 5;
	public static int min = 0;
	
	public Element(String nom, int evaluation) {
		
		this.nom = nom;
		this.evaluation = evaluation;
		
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(int evaluation) {
		this.evaluation = evaluation;
	}
	
	public void inc() {
		
		if(evaluation < max) {
			evaluation++;
		}
		
	}
	
	public void dec() {
		
		if(evaluation > min) {
			evaluation--;
		}
		
	}
	
	public boolean isMax() {
		return max == evaluation;
	}
	
	public boolean isMin() {
		return min == evaluation;
	}

	@Override
	public boolean equals(Object obj) {
		
		if(obj == null) {
			return false;
		}
		
		if(!(obj instanceof Element)) {
			return false;
		}
		
		return ((Element)obj).getNom().equals(nom);
	}

}
