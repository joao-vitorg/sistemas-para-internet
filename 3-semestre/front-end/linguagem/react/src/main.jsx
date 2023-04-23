import { StrictMode } from "react";
import ReactDOM from "react-dom/client";
import { RouterProvider } from "react-router-dom";
import App from "./App";

ReactDOM.createRoot(document.getElementById("root")).render(
	<StrictMode>
		<RouterProvider router={App} />
	</StrictMode>
);
