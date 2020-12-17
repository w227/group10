package com.example.data12_17homework.bean;

import java.util.List;

public class ImageBean {

    /**
     * status : 200
     * message : 成功
     * data : {"data":[{"id":1578920479,"itemId":1608198082839,"itemType":1,"createTime":1608198082839,"duration":0,"feeds_text":"看世界在等着我们","authorId":1606825189,"activityIcon":null,"activityText":"多彩生活","width":720,"height":1280,"url":null,"cover":"https://pipijoke.oss-cn-hangzhou.aliyuncs.com/1608198034452.jpeg","author":{"id":2415,"userId":1606825189,"name":"月亮会反光","avatar":"http://qzapp.qlogo.cn/qzapp/101794421/F8FA1AD786173472C1AA448AD217C890/100","description":null,"likeCount":1,"topCommentCount":0,"followCount":0,"followerCount":0,"qqOpenId":"F8FA1AD786173472C1AA448AD217C890","expires_time":1614601190192,"score":0,"historyCount":19,"commentCount":2,"favoriteCount":1,"feedCount":0,"hasFollow":false},"topComment":null,"ugc":{"likeCount":1,"shareCount":0,"commentCount":1,"hasFavorite":false,"hasLiked":false,"hasdiss":false,"hasDissed":false}}]}
     */

    private int status;
    private String message;
    private DataBeanX data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBeanX getData() {
        return data;
    }

    public void setData(DataBeanX data) {
        this.data = data;
    }

    public static class DataBeanX {
        private List<DataBean> data;

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * id : 1578920479
             * itemId : 1608198082839
             * itemType : 1
             * createTime : 1608198082839
             * duration : 0.0
             * feeds_text : 看世界在等着我们
             * authorId : 1606825189
             * activityIcon : null
             * activityText : 多彩生活
             * width : 720
             * height : 1280
             * url : null
             * cover : https://pipijoke.oss-cn-hangzhou.aliyuncs.com/1608198034452.jpeg
             * author : {"id":2415,"userId":1606825189,"name":"月亮会反光","avatar":"http://qzapp.qlogo.cn/qzapp/101794421/F8FA1AD786173472C1AA448AD217C890/100","description":null,"likeCount":1,"topCommentCount":0,"followCount":0,"followerCount":0,"qqOpenId":"F8FA1AD786173472C1AA448AD217C890","expires_time":1614601190192,"score":0,"historyCount":19,"commentCount":2,"favoriteCount":1,"feedCount":0,"hasFollow":false}
             * topComment : null
             * ugc : {"likeCount":1,"shareCount":0,"commentCount":1,"hasFavorite":false,"hasLiked":false,"hasdiss":false,"hasDissed":false}
             */

            private int id;
            private long itemId;
            private int itemType;
            private long createTime;
            private double duration;
            private String feeds_text;
            private int authorId;
            private Object activityIcon;
            private String activityText;
            private int width;
            private int height;
            private Object url;
            private String cover;
            private AuthorBean author;
            private Object topComment;
            private UgcBean ugc;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public long getItemId() {
                return itemId;
            }

            public void setItemId(long itemId) {
                this.itemId = itemId;
            }

            public int getItemType() {
                return itemType;
            }

            public void setItemType(int itemType) {
                this.itemType = itemType;
            }

            public long getCreateTime() {
                return createTime;
            }

            public void setCreateTime(long createTime) {
                this.createTime = createTime;
            }

            public double getDuration() {
                return duration;
            }

            public void setDuration(double duration) {
                this.duration = duration;
            }

            public String getFeeds_text() {
                return feeds_text;
            }

            public void setFeeds_text(String feeds_text) {
                this.feeds_text = feeds_text;
            }

            public int getAuthorId() {
                return authorId;
            }

            public void setAuthorId(int authorId) {
                this.authorId = authorId;
            }

            public Object getActivityIcon() {
                return activityIcon;
            }

            public void setActivityIcon(Object activityIcon) {
                this.activityIcon = activityIcon;
            }

            public String getActivityText() {
                return activityText;
            }

            public void setActivityText(String activityText) {
                this.activityText = activityText;
            }

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }

            public Object getUrl() {
                return url;
            }

            public void setUrl(Object url) {
                this.url = url;
            }

            public String getCover() {
                return cover;
            }

            public void setCover(String cover) {
                this.cover = cover;
            }

            public AuthorBean getAuthor() {
                return author;
            }

            public void setAuthor(AuthorBean author) {
                this.author = author;
            }

            public Object getTopComment() {
                return topComment;
            }

            public void setTopComment(Object topComment) {
                this.topComment = topComment;
            }

            public UgcBean getUgc() {
                return ugc;
            }

            public void setUgc(UgcBean ugc) {
                this.ugc = ugc;
            }

            public static class AuthorBean {
                /**
                 * id : 2415
                 * userId : 1606825189
                 * name : 月亮会反光
                 * avatar : http://qzapp.qlogo.cn/qzapp/101794421/F8FA1AD786173472C1AA448AD217C890/100
                 * description : null
                 * likeCount : 1
                 * topCommentCount : 0
                 * followCount : 0
                 * followerCount : 0
                 * qqOpenId : F8FA1AD786173472C1AA448AD217C890
                 * expires_time : 1614601190192
                 * score : 0
                 * historyCount : 19
                 * commentCount : 2
                 * favoriteCount : 1
                 * feedCount : 0
                 * hasFollow : false
                 */

                private int id;
                private int userId;
                private String name;
                private String avatar;
                private Object description;
                private int likeCount;
                private int topCommentCount;
                private int followCount;
                private int followerCount;
                private String qqOpenId;
                private long expires_time;
                private int score;
                private int historyCount;
                private int commentCount;
                private int favoriteCount;
                private int feedCount;
                private boolean hasFollow;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getUserId() {
                    return userId;
                }

                public void setUserId(int userId) {
                    this.userId = userId;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getAvatar() {
                    return avatar;
                }

                public void setAvatar(String avatar) {
                    this.avatar = avatar;
                }

                public Object getDescription() {
                    return description;
                }

                public void setDescription(Object description) {
                    this.description = description;
                }

                public int getLikeCount() {
                    return likeCount;
                }

                public void setLikeCount(int likeCount) {
                    this.likeCount = likeCount;
                }

                public int getTopCommentCount() {
                    return topCommentCount;
                }

                public void setTopCommentCount(int topCommentCount) {
                    this.topCommentCount = topCommentCount;
                }

                public int getFollowCount() {
                    return followCount;
                }

                public void setFollowCount(int followCount) {
                    this.followCount = followCount;
                }

                public int getFollowerCount() {
                    return followerCount;
                }

                public void setFollowerCount(int followerCount) {
                    this.followerCount = followerCount;
                }

                public String getQqOpenId() {
                    return qqOpenId;
                }

                public void setQqOpenId(String qqOpenId) {
                    this.qqOpenId = qqOpenId;
                }

                public long getExpires_time() {
                    return expires_time;
                }

                public void setExpires_time(long expires_time) {
                    this.expires_time = expires_time;
                }

                public int getScore() {
                    return score;
                }

                public void setScore(int score) {
                    this.score = score;
                }

                public int getHistoryCount() {
                    return historyCount;
                }

                public void setHistoryCount(int historyCount) {
                    this.historyCount = historyCount;
                }

                public int getCommentCount() {
                    return commentCount;
                }

                public void setCommentCount(int commentCount) {
                    this.commentCount = commentCount;
                }

                public int getFavoriteCount() {
                    return favoriteCount;
                }

                public void setFavoriteCount(int favoriteCount) {
                    this.favoriteCount = favoriteCount;
                }

                public int getFeedCount() {
                    return feedCount;
                }

                public void setFeedCount(int feedCount) {
                    this.feedCount = feedCount;
                }

                public boolean isHasFollow() {
                    return hasFollow;
                }

                public void setHasFollow(boolean hasFollow) {
                    this.hasFollow = hasFollow;
                }
            }

            public static class UgcBean {
                /**
                 * likeCount : 1
                 * shareCount : 0
                 * commentCount : 1
                 * hasFavorite : false
                 * hasLiked : false
                 * hasdiss : false
                 * hasDissed : false
                 */

                private int likeCount;
                private int shareCount;
                private int commentCount;
                private boolean hasFavorite;
                private boolean hasLiked;
                private boolean hasdiss;
                private boolean hasDissed;

                public int getLikeCount() {
                    return likeCount;
                }

                public void setLikeCount(int likeCount) {
                    this.likeCount = likeCount;
                }

                public int getShareCount() {
                    return shareCount;
                }

                public void setShareCount(int shareCount) {
                    this.shareCount = shareCount;
                }

                public int getCommentCount() {
                    return commentCount;
                }

                public void setCommentCount(int commentCount) {
                    this.commentCount = commentCount;
                }

                public boolean isHasFavorite() {
                    return hasFavorite;
                }

                public void setHasFavorite(boolean hasFavorite) {
                    this.hasFavorite = hasFavorite;
                }

                public boolean isHasLiked() {
                    return hasLiked;
                }

                public void setHasLiked(boolean hasLiked) {
                    this.hasLiked = hasLiked;
                }

                public boolean isHasdiss() {
                    return hasdiss;
                }

                public void setHasdiss(boolean hasdiss) {
                    this.hasdiss = hasdiss;
                }

                public boolean isHasDissed() {
                    return hasDissed;
                }

                public void setHasDissed(boolean hasDissed) {
                    this.hasDissed = hasDissed;
                }
            }
        }
    }
}
