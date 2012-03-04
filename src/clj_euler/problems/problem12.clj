(ns clj-euler.problems.problem12
  (:use [clj-euler.math :only (num-divisors)])
  (:use [clj-euler.lazy-seqs :only (triangle-numbers)]))

(def problem12 (first (drop-while #(<= (num-divisors %) 500) (triangle-numbers))))