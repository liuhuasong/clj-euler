(ns clj-euler.problems.problem24
  (:use [clojure.contrib.combinatorics :only (lex-permutations)]))

(def problem24 (nth (lex-permutations [0 1 2 3 4 5 6 7 8 9]) 999999))