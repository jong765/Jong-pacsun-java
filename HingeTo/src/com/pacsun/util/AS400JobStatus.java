package com.pacsun.util;

import com.ibm.as400.access.AS400;
import com.ibm.as400.access.Job;
import com.ibm.as400.access.JobList;
import java.beans.PropertyVetoException;
import java.util.Enumeration;

public class AS400JobStatus
{
  private String systemName;
  private String userName;
  private String password;

  public boolean isActive(String jobName)
    throws Exception
  {
    AS400 system = new AS400(this.systemName);
    boolean isActive = false;

    JobList jobList = new JobList(system);
    try {
      jobList.addJobSelectionCriteria(1, jobName);
    }
    catch (PropertyVetoException e1) {
      e1.printStackTrace();
    }

    Enumeration jobEnum = null;
    try {
      jobEnum = jobList.getJobs();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    do
    {
      Job job = (Job)jobEnum.nextElement();
      if (job.getStatus().equalsIgnoreCase("*Active")) {
        isActive = true;
        break;
      }
    }
    while (jobEnum.hasMoreElements());

    return isActive;
  }

  public String getSystemName()
  {
    return this.systemName;
  }

  public void setSystemName(String systemName) {
    this.systemName = systemName;
  }

  public String getUserName() {
    return this.userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.pacsun.util.AS400JobStatus
 * JD-Core Version:    0.6.0
 */