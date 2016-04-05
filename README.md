# identifier-tokenizer

[![Build Status](https://travis-ci.org/anqooqie/identifier-tokenizer.svg)](https://travis-ci.org/anqooqie/identifier-tokenizer)

A simple tokenizer for identifier names

## Usage
    git clone https://github.com/anqooqie/identifier-tokenizer.git
    cd identifier-tokenizer
    make
    java -cp bin jp.ac.tsukuba.cs.kde.hfukuda.tokenizer.Main <input >output

## Example of Input
    DoublyLinkedList
    JDBCTest
    SSL2TransmissionImplVersion4
    KDE_IdentifierTokenizer
    123InvalidIdentifierName
    NotASCIIなIdentifierName

## Example of Output
    Doubly	Linked	List
    JDBC	Test
    SSL2	Transmission	Impl	Version4
    KDE	Identifier	Tokenizer
    N/A
    N/A
