Links:
- https://www.guru99.com/clustered-vs-non-clustered-index.html

# DATABASE

Differences between No-SQL and SQL databases
## 1. Data Model:
    SQL databases uses a structured tabular data model, where data is organized in rows and columns in tables.
    While, NoSQL databases use a variety of data models, including document, key-value, wide-column, and graph.

## 2. Schema:
    SQL databases have a fixed schema, thus the structure of the data has to be predefined, while NoSQL databases
    have a flexible or dynamic schema, thus the structure of the data can change over time.

## 3. ACID principles:
    SQL databases support ACID principles, while NoSQL databases may or may not support ACID principles depending on the
    specific database and the data model being used.
## 4. Use cases:
    SQL databases are well-suited for structured, transactional data and are often used in applications such as
    financial systems, HR applications, and ecommerce applications. While NoSQL databases are suitable for unstructured,
    large scale data and are often used in applications such as real-time analytics, social networking, content management etc.


## Factors to consider for choosing between SQL and NoSQL databases.
- Define the requirements: Work out the needs of your app and the type of data you would be handling.
- Consider your data model: Figure out the structure of your data, and how it will be stored and accessed.

## ACID PRINCIPLES
- `Atomicity`: Atomicity ensures that a transaction is treated as a single, indivisible unit of work. It guarantees that either all changes made within a transaction are successfully committed, or none of them are. If any part of the transaction fails, all changes are rolled back, and the database remains unchanged.
    
    Example: Imagine you want to transfer funds from one bank account to another. The atomicity principle ensures that if the withdrawal from the source account succeeds, the deposit into the destination account will also succeed. If there's an error during the transfer, both accounts will be rolled back to their initial state, avoiding an inconsistent state where one account is debited, and the other is not credited._

- `Consistency`: Consistency ensures that a transaction brings the database from one valid state to another valid state. It enforces the integrity rules and constraints defined on the database, preventing any transaction from leaving the database in an invalid or inconsistent state.

    Example: Suppose you have a database where every customer must have a unique email address. When inserting a new customer, the consistency principle ensures that the database checks if the email address is already in use. If it is, the transaction is aborted, and the database remains consistent, preventing duplicate email addresses.

- `Isolation`: Isolation ensures that concurrent transactions do not interfere with each other, providing a higher level of data integrity and preventing data anomalies. Each transaction should operate as if it is the only transaction being executed, even when multiple transactions are executing concurrently.

    Example: Consider a scenario where two users simultaneously update the same bank account balance. The isolation principle ensures that the updates are executed in a way that they don't interfere with each other. For instance, one user's transaction should not see the intermediate state of the other user's transaction. This prevents issues like incorrect balance calculations or lost updates.

- `Durability`: Durability guarantees that once a transaction is committed, its changes are permanent and will survive any subsequent failures, such as power outages or system crashes. Committed data is stored in non-volatile storage, typically disk or solid-state drives, to ensure its durability.

    Example: If a database system crashes immediately after a successful commit, the durability principle ensures that the changes made by the committed transaction are still preserved when the system recovers. The data is not lost due to the failure, providing confidence in the reliability of the database.


Clustered and Non-Clustered databases are two (2) different approaches to organizing and accessing data in a database system.
- # Clustered databases: 
  - The data is physically stored together on disk based on a specific clustering key or index. 
  - They are designed to optimize data retrieval for queries that commonly access related data together.
  - They are commonly used in systems where data retrieval patterns are known in advance or where data is frequently accessed in a specific order.
- # Non-Clustered databases:
  - The physical order of the data is not tied to its logical order as the data is stored independently of the physical order of the disk.
  - The data is stored using a separate index structure that allows for efficient data retrieval based on indexed columns.
  - They are suitable for scenarios where the access patterns are diverse, and there is a need for efficient random access or frequent data modification.

In relational databases, there are several types of indexes that can be used to improve query performance and data retrieval. The common types of indexes include:

## Clustered Index: 
A clustered index determines the physical order of data in a table. Each table can have only one clustered index. It defines the order of rows in the table based on the values of one or more columns. Typically, the clustered index is created on the primary key column(s) of a table. In some databases, such as SQL Server, the clustered index is the table itself.

## Non-Clustered Index: 
A non-clustered index is a separate structure from the actual table that contains a copy of selected columns and a pointer to the corresponding table rows. It does not affect the physical order of data in the table. A table can have multiple non-clustered indexes. Non-clustered indexes are useful for improving the performance of queries involving filtering, sorting, and joining.

## Unique Index: 
A unique index enforces the uniqueness constraint on one or more columns. It ensures that the indexed columns contain unique values, preventing duplicate entries. A table can have multiple unique indexes, and unique indexes can be clustered or non-clustered.

## Primary Key Index: 
A primary key index is a unique index created on the primary key column(s) of a table. It enforces the primary key constraint, which ensures that each row in the table is uniquely identified by its primary key value. By default, a primary key index is clustered, but it can also be non-clustered.

## Foreign Key Index: 
A foreign key index is created on the columns referenced by a foreign key constraint. It improves the performance of queries involving joins between related tables.

## Bitmap Index: 
A bitmap index is an index type that uses bitmap vectors to represent the indexed values. It is efficient for columns with a low cardinality (a small number of distinct values). Bitmap indexes are suitable for read-intensive workloads and can provide fast query performance for specific types of queries.

## Partial Index: 
A partial index is an index that includes only a subset of the rows in a table. It is created based on a specific condition (predicate). Partial indexes can reduce the index size and improve query performance for specific subsets of data.

## Covering Index: 
A covering index is an index that includes all the columns required to satisfy a query, eliminating the need to access the actual table data. It can improve query performance by allowing the database to retrieve the necessary data directly from the index.