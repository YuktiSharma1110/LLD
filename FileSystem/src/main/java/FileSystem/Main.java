package FileSystem;

public class Main {
    public static void main(String[] args)
    {
       System.out.println("Welcome to the File System...");

       Directory movieDirectory = new Directory("Movie");


       FileSystem inception = new File("Inception");

        movieDirectory.add(inception);

        Directory thrillerMovie= new Directory("Thriller");
        movieDirectory.add(thrillerMovie);


        File thrillerMovieName = new File("The Departed");
        thrillerMovie.add(thrillerMovieName);

        movieDirectory.ls();

    }
}