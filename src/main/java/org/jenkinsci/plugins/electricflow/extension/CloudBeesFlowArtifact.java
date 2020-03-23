package org.jenkinsci.plugins.electricflow.extension;

import hudson.model.Run;
import hudson.model.Run.ArtifactList;
import hudson.model.Run.Artifact;
import net.sf.json.JSONObject;
import org.jenkinsci.plugins.electricflow.FlowArtifactObject;

public class CloudBeesFlowArtifact {
  protected String relativePath;
  protected String displayPath;
  protected String name;
  protected String href;
  protected String length;
  protected long size;
  protected FlowArtifactObject artifactDetails;

  public CloudBeesFlowArtifact() {}

  public static CloudBeesFlowArtifact build(Artifact obj, FlowArtifactObject artifactDetails) {
    CloudBeesFlowArtifact cloudBeesFlowArtifact = new CloudBeesFlowArtifact();

    cloudBeesFlowArtifact.setDisplayPath(obj.getDisplayPath());
    // todo: switch to relativePath
    cloudBeesFlowArtifact.setRelativePath(obj.getDisplayPath());
    cloudBeesFlowArtifact.setName(obj.getFileName());
    cloudBeesFlowArtifact.setHref(obj.getHref());
    cloudBeesFlowArtifact.setLength(obj.getLength());
    cloudBeesFlowArtifact.setSize(obj.getFileSize());
    cloudBeesFlowArtifact.setArtifactDetails(artifactDetails);

    return cloudBeesFlowArtifact;
  }

  public long getSize() {
    return size;
  };

  public void setSize(long size) {
    this.size = size;
   }

   public JSONObject toJsonObject() {
    JSONObject json = new JSONObject();

    if (this.getDisplayPath() != null) {
        json.put("displayPath", this.getDisplayPath());
    }

    //Workaround until we have a way to unambiguously get the type of
    //Repository - For example, Flow Artifact Repository or Artifact Subsystem etc.,
    json.put("repositoryType", "Flow Artifact Repository");

    if (this.getName() != null) {
        json.put("name", this.getName());
    }
    if (this.getHref() != null) {
        json.put("href", this.getHref());
    }
    if (this.getSize() > 0) {
        json.put("size", this.getSize());
    }
    if (this.artifactDetails != null){
        json.put("artifactName", artifactDetails.getArtifactName());
        json.put("artifactVersion", artifactDetails.getArtifactVersion());
        json.put("repositoryName", artifactDetails.getRepositoryName());
        json.put("url", artifactDetails.getArtifactURL());
    }


    //VJN : Currently hardcoded
    //json.put("artifactName", "com.demo:helloworld");
    //json.put("artifactVersion", "1.0-SNAPSHOT");
    //json.put("repositoryName", "default");
    //json.put("url", "https://35.230.91.86/commander/link/artifactVersionDetails/artifactVersions/com.demo%3Ahelloworld%3A1.0-SNAPSHOT?s=Artifacts&ss=Artifacts");

    if (this.getSize() > 0) {
        json.put("size", this.getSize());
    }


    return json;
}

  public String getRelativePath() {
    return relativePath;
  }

  public void setRelativePath(String relativePath) {
    this.relativePath = relativePath;
  }

  public String getDisplayPath() {
    return displayPath;
  }

  public void setDisplayPath(String displayPath) {
    this.displayPath = displayPath;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }
  public void setLength(String length) {
    this.length = length;
  }

  public String getLength() {
    return length;
  }
  public void setArtifactDetails(FlowArtifactObject artifactDetails) {
        this.artifactDetails = artifactDetails;
  }
  public FlowArtifactObject getArtifactDetails() { return artifactDetails; }
}
