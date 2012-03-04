(ns clj-euler.problems.problem10
  (:use [clojure.contrib.lazy-seqs :only (primes)]))

(def problem10 (reduce + (take-while #(< % 2000000) primes)))