package com.detector.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Text Analysis Result - Contains all detection results and feature analysis
 */
public class TextAnalysisResult {
    
    private double aiScore;                    // Overall AI probability score (0-100)
    private String riskLevel;                  // LOW, MEDIUM, HIGH
    private Map<String, Double> featureScores; // Individual feature scores
    private Map<String, Object> details;       // Detailed analysis results
    private long analysisTime;                 // Time taken for analysis (ms)
    
    public TextAnalysisResult() {
        this.featureScores = new HashMap<>();
        this.details = new HashMap<>();
        this.analysisTime = 0;
    }
    
    // Getters and Setters
    public double getAiScore() {
        return aiScore;
    }
    
    public void setAiScore(double aiScore) {
        this.aiScore = Math.max(0, Math.min(100, aiScore)); // Clamp between 0-100
        updateRiskLevel();
    }
    
    public String getRiskLevel() {
        return riskLevel;
    }
    
    private void updateRiskLevel() {
        if (aiScore < 30) {
            this.riskLevel = "LOW";
        } else if (aiScore < 60) {
            this.riskLevel = "MEDIUM";
        } else {
            this.riskLevel = "HIGH";
        }
    }
    
    public Map<String, Double> getFeatureScores() {
        return featureScores;
    }
    
    public void setFeatureScores(Map<String, Double> featureScores) {
        this.featureScores = featureScores;
    }
    
    public void addFeatureScore(String featureName, double score) {
        this.featureScores.put(featureName, score);
    }
    
    public Map<String, Object> getDetails() {
        return details;
    }
    
    public void setDetails(Map<String, Object> details) {
        this.details = details;
    }
    
    public void addDetail(String key, Object value) {
        this.details.put(key, value);
    }
    
    public long getAnalysisTime() {
        return analysisTime;
    }
    
    public void setAnalysisTime(long analysisTime) {
        this.analysisTime = analysisTime;
    }
    
    @Override
    public String toString() {
        return "TextAnalysisResult{" +
                "aiScore=" + aiScore +
                ", riskLevel='" + riskLevel + '\'' +
                ", analysisTime=" + analysisTime + "ms" +
                ", featureScores=" + featureScores +
                '}';
    }
}