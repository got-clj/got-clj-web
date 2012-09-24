(ns got-clj-web.models.twitter
  (:require [clojure.data.json :as json])
  (:use clojure.pprint))

(def url "https://twitter.com/statuses/user_timeline/gotclj.json")

(defn tweets-json []
  (json/read-json (slurp url)))

(map #(->> %
           :created_at
           ))
(defn tweets-frequencies
  []
  (frequencies
   (map (comp
         #(vector (.getYear %) (.getMonth %) (.getDate %))
         #(new java.util.Date (java.util.Date/parse %))
         :created_at)
        (tweets-json))))

(defn fetch-new-tweets
  []
  (map :text (tweets-json)))




