package com.spring.app.model;

import javax.persistence.Embeddable;

@Embeddable
public class SkillObj {
    private String skill;
    private String rating;
    private String experience;

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public SkillObj(String skill, String rating, String experience) {
        this.skill = skill;
        this.rating = rating;
        this.experience = experience;
    }

    public SkillObj() {
    }

    @Override
    public String toString() {
        return "SkillObj{" +
                "skill='" + skill + '\'' +
                ", rating='" + rating + '\'' +
                ", experience='" + experience + '\'' +
                '}';
    }
}
