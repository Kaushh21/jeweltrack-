// src/api/auth.js
import axios from "axios";

const API = axios.create({
  baseURL: "http://localhost:8080/api/auth",
  withCredentials: true, // allows session cookies
});

export const register = (data) => API.post("/register", data);
export const login = (data) => API.post("/login", data);
export const getCurrentUser = () => API.get("/me");
export const logout = () => API.post("/logout");
