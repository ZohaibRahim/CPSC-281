# CuckooHashMap - Java Implementation

This repository contains a Java implementation of the Cuckoo Hash Map, an interesting strategy for hashing with open addressing. The CuckooHashMap class includes methods for inserting, retrieving, and removing key-value pairs based on two independent hash functions for each key. The strategy guarantees constant time insertion under certain load factor conditions and constant time search.

Key Features:
1) CuckooHashMap class: Complete implementation of a Cuckoo Hash Map in Java.
2) Two independent hash functions: Utilizes two hash functions for each key to determine the storage location.
3) Constant time insertion: Ensures expected constant time insertion for load factors below 0.5.
4) Constant time search: Enables constant time search as the key can only be stored in one of two possible locations.
5) Collision resolution: Employs a cuckoo hashing strategy to handle collisions and ensure data integrity.
