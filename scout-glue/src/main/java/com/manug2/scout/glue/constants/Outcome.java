package com.manug2.scout.glue.constants;

public enum Outcome {

	SUCCESS(new String[]{"success", "succeeded", "successfully", "OK", "Login Success"}),
	FAILURE(new String[]{"failure", "failed", "unsuccessfully", "NOK", "Login Failed"});
	
	private String[] aliases;
	
	private Outcome(String[] aliases){
        this.aliases = aliases;
	}

	public static Outcome outcomeForName(String outcomeString) throws IllegalArgumentException{
        for(Outcome outcome: values()){
        	for(String alias: outcome.aliases){
        		if(alias.equalsIgnoreCase(outcomeString)){
        			return outcome;
        		}
        	}
        }
        throw outcomeNotFound(outcomeString);
    }

    private static IllegalArgumentException outcomeNotFound(String outcome) {
        return new IllegalArgumentException(("Invalid outcome [" + outcome + "]"));
    }
}
