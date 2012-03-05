(ns clj-euler.problems.problem21
  (:use [clj-euler.lazy-seqs :only (amicables)]))

(time (def problem21 (reduce + (take-while #(< % 10000) (amicables)))))