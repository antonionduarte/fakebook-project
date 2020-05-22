package fanaticisms;

public class FanaticismClass implements Fanaticism {
    
    /* Variables */
    private String hashtag;
    private boolean stance;
    
    /**
     * Constructor.
     * @param hashtag The fanaticisms' hashtag.
     * @param stance The fanaticisms' stance.
     */
    public FanaticismClass(String hashtag, String stance) {
        this.hashtag = hashtag;
        this.stance = stance.equals("loves");
    }
    
    /**
     * @return The fanaticisms' hashtag.
     */
    @Override
    public String getHashtag() {
        return hashtag;
    }
    
    /**
     * @return The fanaticisms' stance.
     */
    @Override
    public boolean getStance() {
        return stance;
    }
    
}