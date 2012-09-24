(ns got-clj-web.views.welcome
  (:require [got-clj-web.views.common :as common]
            [got-clj-web.models.twitter :as tw]
            [noir.content.getting-started])
  (:use [noir.core :only [defpage]]))

(defpage "/welcome" []
         (common/layout
          [:div.tweets
           [:h1 "Got Clj Tweets"]
           [:div
            [:h1 "Frequencies"]]

           [:ul
            (for [tweet (tw/fetch-new-tweets)]
              [:li [:h2 tweet]])]]))
          

