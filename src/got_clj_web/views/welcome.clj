(ns got-clj-web.views.welcome
  (:require [got-clj-web.views.common :as common]
            [noir.content.getting-started])
  (:use [noir.core :only [defpage]]))

(defpage "/welcome" []
         (common/layout
           [:p "Welcome to got-clj-web"]))
