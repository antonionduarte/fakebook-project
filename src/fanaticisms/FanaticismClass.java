package fanaticisms;

import enums.Stance;

public class FanaticismClass implements Fanaticism {
    
    /* Variables */
    private String hashtag;
    private Stance stance;
    
    /**
     * Constructor.
     * @param hashtag The fanaticisms' hashtag.
     * @param stance The fanaticisms' stance.
     */
    public FanaticismClass(String hashtag, String stance) {
        this.hashtag = hashtag;
        this.stance = Stance.valueOf(stance.toUpperCase());
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
        return stance.getValue();
    }
    
}