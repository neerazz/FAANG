## Actors

1. Librarian
2. Member
3. System

## Use Cases
1. Add/Remove/Edit Books
2. Search Books
3. Create New User/Cancel a User
4. Borrow/Return a book
5. Reserve a book
6. Renew a book - Already borrowed

### Class
```
Library
Book
BookItem
Account
LibraryCard

BookReservation
BookLending
Catalog
Fine
Author
Rack
Notification
```

## Flow 
### Loan a book
1. Scan Library Card
2. Scan Book
3. Check - Can loan book not reference book
4. Check - Does user have less than 5 loans
5. Check - If book has been reserved
6. Create an order
7. Update status of book to Loaned
8.Increase no of assigned books to user
9. If reservation made  - Mark complete

### Return a book
1. Scan Library Card
2. Scan Book
3. Check - Is there a fine on the book - If not calculate fine
4. Check if book has been reserved - Update

