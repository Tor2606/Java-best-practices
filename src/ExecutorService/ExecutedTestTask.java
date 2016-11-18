package ExecutorService;

public class ExecutedTestTask implements Runnable {
    private String taskName;
    public ExecutedTestTask(String taskName){
        this.taskName = taskName;
    }
    @Override
    public void run() {
        try{
            System.out.println(this.taskName + " is sleeping..." + System.currentTimeMillis());
            Thread.sleep(3000);
            System.out.println(this.taskName + " is running..." + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
}
