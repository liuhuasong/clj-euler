(ns clj-euler.problems.problem9
  (:use [clj-euler.lazy-seqs :only (pyth-triplets)]))

(def problem9 (reduce * (first (filter #(= 1000 (reduce + %)) (pyth-triplets)))))