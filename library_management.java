import java.util.*;
class Book{
    private String bookId;
    private String title;
    private boolean available;
    private Member borrowedBy;
    Book(String bookId, String title){
        this.bookId=bookId;
        this.title=title;
        this.available=true;
        this.borrowedBy=null;
    }
    String getBookId(){
        return bookId;
    }
    String getTitle(){
        return title;
    }
    boolean isAvailable(){
        return available;
    }
    boolean issueTo(Member member){
        if(!available){
            return false;
        }
        available=false;
        borrowedBy=member;
        return true;
    }
    boolean returnBook(Member member){
        if (borrowedBy!=member){
            return false;
        }
        available=true;
        borrowedBy=null;
        return true;
    }
    double calculateLateFee(int lateDays){
        return lateDays*5.0;
    }
}
abstract class Member{
    private String memberId;
    private String name;
    private ArrayList<Book> borrowedBooks;
    Member(String memberId, String name){
        this.memberId=memberId;
        this.name=name;
        borrowedBooks=new ArrayList<>();
    }
    String getMemberId(){
        return memberId;
    }
    String getName(){
        return name;
    }
    abstract int getBorrowingLimit();
    boolean canBorrow(){
        return borrowedBooks.size() < getBorrowingLimit();
    }
    void addBook(Book book){
        borrowedBooks.add(book);
    }
    void removeBook(Book book){
        borrowedBooks.remove(book);
    }
    int getBorrowedCount(){
        return borrowedBooks.size();
    }
}
class StudentMember extends Member{
    StudentMember(String memberId, String name){
        super(memberId, name);
    }
    @Override
    int getBorrowingLimit(){
        return 2;
    }
}
class FacultyMember extends Member{
    FacultyMember(String memberId, String name){
        super(memberId, name);
    }
    @Override
    int getBorrowingLimit(){
        return 5;
    }
}
class GuestMember extends Member{
    GuestMember(String memberId, String name){
        super(memberId, name);
    }
    @Override
    int getBorrowingLimit(){
        return 1;
    }
}
class Library{
    private ArrayList<Book> books;
    Library(){
        books=new ArrayList<>();
    }
    void addBook(Book book){
        books.add(book);
    }
    Book findBook(String bookId){
        for(Book book:books){
            if(book.getBookId().equals(bookId)){
                return book;
            }
        }
        return null;
    }
    void issueBook(String bookId, Member member){
        Book book=findBook(bookId);
        if(book==null) {
            System.out.println("Borrow failed: Book not found");
            return;
        }
        if(!member.canBorrow()){
            System.out.println("Borrow failed: Borrowing limit reached");
            return;
        }
        if(!book.isAvailable()){
            System.out.println("Borrow failed: Book unavailable");
            return;
        }
        if(book.issueTo(member)){
            member.addBook(book);
            System.out.println("Borrowed: " + book.getTitle());
        }
    }
    void returnBook(String bookId, Member member){
        Book book=findBook(bookId);
        if(book==null){
            System.out.println("Return failed: Book not found");
            return;
        }
        if(book.returnBook(member)){
            member.removeBook(book);
            System.out.println("Returned: " + book.getTitle());
        }
        else{
            System.out.println("Return failed: Book was not borrowed by this member");
        }
    }
}
class Librarian{
    private String librarianId;
    private String name;
    Librarian(String librarianId, String name){
        this.librarianId = librarianId;
        this.name = name;
    }
    void issueBook(Library library, String bookId, Member member){
        library.issueBook(bookId, member);
    }
    void returnBook(Library library, String bookId, Member member){
        library.returnBook(bookId, member);
    }
}
public class library_management{
    public static void main(String[] args) {
        Scanner inp=new Scanner(System.in);
        Library library=new Library();
        int n=inp.nextInt();
        for(int i=0;i<n;i++){
            String bookId=inp.next();
            String title=inp.next();
            Book book=new Book(bookId, title);
            library.addBook(book);
        }
        String memberType=inp.next();
        String memberId=inp.next();
        String memberName=inp.next();
        Member member;
        if(memberType.equals("STUDENT")){
            member=new StudentMember(memberId, memberName);
        }
        else if(memberType.equals("FACULTY")){
            member=new FacultyMember(memberId, memberName);
        }
        else{
            member=new GuestMember(memberId, memberName);
        }
        Librarian librarian=new Librarian("L001", "LibraryAdmin");
        int M=inp.nextInt();
        for(int i=0;i<M;i++){
            String operation=inp.next();
            String bookId=inp.next();
            if(operation.equals("BORROW")){
                librarian.issueBook(library, bookId, member);
            }
            else if(operation.equals("RETURN")){
                librarian.returnBook(library, bookId, member);
            }
        }
        System.out.println("Books Borrowed: " + member.getBorrowedCount());
        inp.close();        
    }
}
