package resources_chief;

public class Responsable
{
    private String name;
    private String status;
    private int projectsCount;
    private int tasksCompleted;
    private int performance;
    private Projet projet;

    public Responsable(String name, String status, int projectsCount, int tasksCompleted, int performance, Projet projet)
    {
        this.name = name;
        this.status = status;
        this.projectsCount = projectsCount;
        this.tasksCompleted = tasksCompleted;
        this.performance = performance;
        this.projet = projet;
    }

    public String getName()
    {
        return name;
    }

    public String getStatus()
    {
        return status;
    }

    public int getProjectsCount()
    {
        return projectsCount;
    }

    public int getTasksCompleted()
    {
        return tasksCompleted;
    }

    public int getPerformance()
    {
        return performance;
    }

    public Projet getProjet()
    {
        return projet;
    }

    public void viewDetails()
    {
        System.out.println("Responsable: " + name + ", Performance: " + performance + "%, Projets: " + projectsCount);
    }
}
