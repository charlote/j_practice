public interface Subject
{
    public void registerO(Observer o);
    public void removeO(Observer o);
    public void notifyO();
}
