package com.example.retrofit3.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Films {

        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("director")
        @Expose
        private String director;
        @SerializedName("producer")
        @Expose
        private String producer;
        @SerializedName("release_date")
        @Expose
        private Integer releaseDate;
        @SerializedName("rt_score")
        @Expose
        private Integer rtScore;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getDirector() {
            return director;
        }

        public void setDirector(String director) {
            this.director = director;
        }

        public String getProducer() {
            return producer;
        }

        public void setProducer(String producer) {
            this.producer = producer;
        }

        public Integer getReleaseDate() {
            return releaseDate;
        }

        public void setReleaseDate(Integer releaseDate) {
            this.releaseDate = releaseDate;
        }

        public Integer getRtScore() {
            return rtScore;
        }

        public void setRtScore(Integer rtScore) {
            this.rtScore = rtScore;
        }

    }
