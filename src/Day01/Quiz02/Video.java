package Day01.Quiz02;

public class Video extends Content{
    public String genre;

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Video(String title, String genre) {
        super(title);
        this.genre = genre;
    }

    @Override
    public void totalPrice() {
        switch (getGenre()){
            case "new" :
                setPrice(2000);
                break;
            case "comic":
                setPrice(1500);
                break;
            case "child":
                setPrice(1000);
                break;
            default:
                setPrice(500);
                break;
        }
    }
}
