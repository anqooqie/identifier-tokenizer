# identifier-tokenizer

[![Build Status](https://travis-ci.org/anqooqie/identifier-tokenizer.svg)](https://travis-ci.org/anqooqie/identifier-tokenizer)

A simple tokenizer for identifier names

## Usage
    git clone https://github.com/anqooqie/identifier-tokenizer.git
    cd identifier-tokenizer
    mvn compile package dependency:copy-dependencies
    java -jar target/identifier-tokenizer-"$(mvn help:evaluate -Dexpression=project.version | grep -v INFO)".jar <input >output

## Example of Input
    DoublyLinkedList
    JDBCTest
    SSL2TransmissionImplVersion4
    KDE_IdentifierTokenizer
    123InvalidIdentifierName
    IdentifierNameContaining$
    NotASCIIなIdentifierName

## Example of Output
    Doubly	Linked	List
    JDBC	Test
    SSL2	Transmission	Impl	Version4
    KDE	Identifier	Tokenizer
    
    
    
