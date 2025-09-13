# 🌟 CampusEcho

**CampusEcho** is a student confession platform built to empower open dialogue and emotional connection across campuses. Designed with classic **JSP/Servlets** and a modular **DAO architecture**, it offers a clean, scalable foundation for anonymous sharing, transparent moderation, and personalized user experiences.

---

## 🚀 Features Implemented

- 📝 **Confession Submission**  
  Users can post anonymous confessions with visible author attribution (`posted_by` field).

- 🛡️ **Admin Moderation Panel**  
  Admins can view pending confessions with author info and approve/reject them.

- 📜 **Confession Feed**  
  Approved confessions are displayed in a scrollable, session-aware feed.

- 🔐 **Login & Signup Pages**  
  Basic authentication flow with styled buttons and form routing.

- 🏠 **Home Page**  
  Welcoming landing page with emotional branding and entry points to login/signup.

---

## 🧠 Tech Stack

| Layer        | Technology         |
|--------------|--------------------|
| Backend      | Java, Servlets     |
| Frontend     | JSP, HTML, CSS     |
| Architecture | DAO Pattern        |
| Database     | MySQL              |

---

## 🎯 Vision

CampusEcho is more than a confession board—it's a safe space for students to express, connect, and be heard. Every feature is designed with clarity, correctness, and emotional resonance in mind.

---

## 💡 Next Milestones

- 💬 **Comment System**  
  Enable users to reply to confessions with nested comments using a `parent_id` structure for threading.

- 👤 **Profile Viewing**  
  Logged-in users can view their own confession history, liked posts, and basic profile info.

- ❤️ **Like/Dislike Tracking**  
  Implement a bridge table to track user reactions with timestamps for analytics and engagement metrics.

- 🔍 **Trending Confessions**  
  Highlight posts with high engagement in the last 24 hours using simple SQL aggregation.

- 🧠 **Sentiment Tagging**  
  Auto-classify confessions as “happy,” “angry,” “sad,” etc., using basic NLP or keyword matching.

