package net.btcmp.timebank.dto;

public class LikesDto {

    private Integer likeCount;

    public LikesDto(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public LikesDto(){
//        empty constructor
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

}
