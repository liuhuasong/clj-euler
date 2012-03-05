(ns clj-euler.problems.problem7
  (:use [clojure.contrib.lazy-seqs :only (primes)]))

(def problem7 (first (drop 10000 primes)))

