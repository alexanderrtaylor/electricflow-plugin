// ElectricFlowGlobalConfiguration.java --
//
// ElectricFlowGlobalConfiguration.java is part of ElectricCommander.
//
// Copyright (c) 2005-2017 Electric Cloud, Inc.
// All rights reserved.
//

package org.jenkinsci.plugins.electricflow;

import hudson.Extension;
import java.util.List;
import jenkins.model.GlobalConfiguration;
import net.sf.json.JSONObject;
import org.kohsuke.stapler.StaplerRequest;

@Extension
public class ElectricFlowGlobalConfiguration extends GlobalConfiguration {

  // ~ Instance fields --------------------------------------------------------

  public List<Configuration> efConfigurations;

  // ~ Constructors -----------------------------------------------------------

  public ElectricFlowGlobalConfiguration() {
    load();
  }

  // ~ Methods ----------------------------------------------------------------

  @Override
  public boolean configure(StaplerRequest req, JSONObject formData) throws FormException {
    this.efConfigurations = req.bindJSONToList(Configuration.class, formData.get("configurations"));
    save();

    return true;
  }

  public List<Configuration> getConfigurations() {
    return this.efConfigurations;
  }
}
