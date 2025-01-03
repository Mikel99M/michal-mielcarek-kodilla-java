package com.kodilla.patterns.strategy.social;

public sealed class User
        permits ZGeneration, YGeneration, Millenials{

    private String name;
    protected SocialPublisher socialPublisher;

    public User(String name) {
        this.name = name;
    }

    public String predict() {
        return socialPublisher.share();
    }

    public void sharePost() {
        System.out.print(name + " is currently using " + socialPublisher.share());
    }

    public void setSocialPublisher(SocialPublisher socialPublisher) {
        this.socialPublisher = socialPublisher;
    }

    public String getName() {
        return name;
    }

    public SocialPublisher getSocialPublisher() {
        return socialPublisher;
    }
}
