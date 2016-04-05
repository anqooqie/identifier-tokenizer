#!/usr/bin/env bats

task() {
  java -cp bin jp.ac.tsukuba.cs.kde.hfukuda.tokenizer.Main 2>/dev/null | sed 's/\r//g'
}

@test '不正な入力を弾く' {
  run task <<'_EOT_'
123InvalidIdentifierName
NotASCIIなIdentifierName
_EOT_
  [ "$status" -eq 0 ]
  [ "${lines[0]}" = 'N/A' ]
  [ "${lines[1]}" = 'N/A' ]
}

@test '単語分割する' {
  run task <<'_EOT_'
DoublyLinkedList
JDBCTest
SSL2TransmissionImplVersion4
KDE_IdentifierTokenizer
_EOT_
  [ "$status" -eq 0 ]
  [ "${lines[0]}" = 'Doubly'$'\t''Linked'$'\t''List' ]
  [ "${lines[1]}" = 'JDBC'$'\t''Test' ]
  [ "${lines[2]}" = 'SSL2'$'\t''Transmission'$'\t''Impl'$'\t''Version4' ]
  [ "${lines[3]}" = 'KDE'$'\t''Identifier'$'\t''Tokenizer' ]
}
