package com.example.finalproj02.model;

import javafx.scene.media.AudioClip;

import java.util.Objects;

public class Audio {
    private final AudioClip clickAudioEffect;
    private final AudioClip pregameAudioEffect;
    private final AudioClip gameAudioEffect;
    private final AudioClip axeManEntranceAudioEffect;
    private final AudioClip hammerManEntranceAudioEffect;
    private final AudioClip buildingCrashingAudioEffect;
    private final AudioClip bombAudioEffect;
    private final AudioClip resultAudioEffect;

    public Audio() {
        String clickAudio = "/com/example/finalproj02/audios/clicks/click-sound-effect.wav";
        String pregameAudio = "/com/example/finalproj02/audios/backgrounds/pregame-bg.mp3";
        String gameAudio = "/com/example/finalproj02/audios/backgrounds/game-bg00.m4a";
        String axeManEntranceAudio = "/com/example/finalproj02/audios/elements/hero/axe-man-entrance.mp3";
        String hammerManEntranceAudio = "/com/example/finalproj02/audios/elements/hero/hammer-man-entrance.mp3";
        String buildingCrashingAudio = "/com/example/finalproj02/audios/elements/building/building-is-done.mp3";
        String bombAudio = "/com/example/finalproj02/audios/elements/bomb/bomb01.wav";
        String resultAudio = "/com/example/finalproj02/audios/backgrounds/result-is-here00.mp3";
        this.clickAudioEffect = new AudioClip(Objects.requireNonNull(getClass().getResource(clickAudio)).toString());
        this.pregameAudioEffect = new AudioClip(Objects.requireNonNull(getClass().getResource(pregameAudio)).toString());
        this.gameAudioEffect = new AudioClip(Objects.requireNonNull(getClass().getResource(gameAudio)).toString());
        this.axeManEntranceAudioEffect = new AudioClip(Objects.requireNonNull(getClass().getResource(axeManEntranceAudio)).toString());
        this.hammerManEntranceAudioEffect = new AudioClip(Objects.requireNonNull(getClass().getResource(hammerManEntranceAudio)).toString());
        this.buildingCrashingAudioEffect = new AudioClip(Objects.requireNonNull(getClass().getResource(buildingCrashingAudio)).toString());
        this.bombAudioEffect = new AudioClip(Objects.requireNonNull(getClass().getResource(bombAudio)).toString());
        this.resultAudioEffect = new AudioClip(Objects.requireNonNull(getClass().getResource(resultAudio)).toString());
    }

    public AudioClip getClickAudioEffect() {
        return clickAudioEffect;
    }

    public AudioClip getPregameAudioEffect() {
        return pregameAudioEffect;
    }

    public AudioClip getGameAudioEffect() {
        return gameAudioEffect;
    }

    public AudioClip getAxeManEntranceAudioEffect() {
        return axeManEntranceAudioEffect;
    }

    public AudioClip getBuildingCrashingAudioEffect() {
        return buildingCrashingAudioEffect;
    }

    public AudioClip getBombAudioEffect() {
        return bombAudioEffect;
    }

    public AudioClip getResultAudioEffect() {
        return resultAudioEffect;
    }

    public AudioClip getHammerManEntranceAudioEffect() {
        return hammerManEntranceAudioEffect;
    }
}
