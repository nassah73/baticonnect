package resources_chief;

import java.util.List;

public class Projet
{
    private String name;
    private Responsable manager;
    private String status;
    private int overallProgress;
    private List<Rapport> rapports;

    public Projet(String name, Responsable manager, String status, int overallProgress)
    {
        this.name = name;
        this.manager = manager;
        this.status = status;
        this.overallProgress = overallProgress;
    }

    public String getName()
    {
        return name;
    }

    public Responsable getManager()
    {
        return manager;
    }

    public String getStatus()
    {
        return status;
    }

    public int getOverallProgress()
    {
        return overallProgress;
    }

    public List<Rapport> getRapports()
    {
        return rapports;
    }

    public void setRapports(List<Rapport> rapports)
    {
        this.rapports = rapports;
    }

    public void showProgress()
    {
        System.out.println(name + " - " + status + " - Progress: " + overallProgress + "%");
    }
}
