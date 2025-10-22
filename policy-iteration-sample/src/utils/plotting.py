from typing import Dict, Tuple, List
import matplotlib.pyplot as plt
import matplotlib.patches as patches
from matplotlib.widgets import Button

ArrowByAction = {
    "left": "←",
    "right": "→",
    "up": "↑",
    "down": "↓",
}

def draw_grid(ax, mdp, policy_map: Dict[Tuple[int, int], str], values_map: Dict[Tuple[int, int], float], title=None):
    ax.clear()
    w, h = mdp.width, mdp.height
    ax.set_xlim(0, w)
    ax.set_ylim(0, h)
    ax.set_aspect("equal")
    ax.set_xticks(range(w + 1))
    ax.set_yticks(range(h + 1))
    ax.grid(True)
    ax.invert_yaxis()  # y=0 at top to match typical gridworld diagrams

    # Draw cells
    for x in range(w):
        for y in range(h):
            cell = (x, y)

            # terminals
            if cell == mdp.terminal_positive:
                rect = patches.Rectangle((x, y), 1, 1, linewidth=1, edgecolor='black', facecolor="#4CAF50")
                ax.add_patch(rect)
                ax.text(x + 0.5, y + 0.55, "+1.00", ha="center", va="center", color="white", fontsize=10, weight="bold")
                continue
            if cell == mdp.terminal_negative:
                rect = patches.Rectangle((x, y), 1, 1, linewidth=1, edgecolor='black', facecolor="#E53935")
                ax.add_patch(rect)
                ax.text(x + 0.5, y + 0.55, "-1.00", ha="center", va="center", color="white", fontsize=10, weight="bold")
                continue

            # obstacle
            if cell in mdp.obstacles:
                rect = patches.Rectangle((x, y), 1, 1, linewidth=1, edgecolor='black', facecolor="#9E9E9E")
                ax.add_patch(rect)
                continue

            # normal cell
            rect = patches.Rectangle((x, y), 1, 1, linewidth=1, edgecolor='black', facecolor="white")
            ax.add_patch(rect)

            # policy arrow
            action = policy_map.get(cell)
            if action:
                ax.text(x + 0.5, y + 0.5, ArrowByAction.get(action, "?"), ha="center", va="center", fontsize=16)

            # value text
            v = values_map.get(cell, 0.0)
            ax.text(x + 0.5, y + 0.85, f"{v:.2f}", ha="center", va="center", fontsize=8, color="#333333")

    if title:
        ax.set_title(title, pad=12)

def animate_policy_iteration(mdp, snapshots: List[tuple], interval_ms=900, save_path=None):
    """
    snapshots: list of (title, policy_map, values_map)
    """
    fig, ax = plt.subplots(figsize=(5, 4))
    def update(i):
        title, pi, V = snapshots[i]
        draw_grid(ax, mdp, pi, V, title=title)

    # Manual stepping (simple and backend-friendly)
    for i, (title, pi, V) in enumerate(snapshots):
        update(i)
        plt.pause(interval_ms / 1000.0)

    if save_path:
        fig.savefig(save_path, dpi=150, bbox_inches="tight")
    plt.show()

def show_snapshots_interactive(mdp, snapshots, save_path=None):
    """
    snapshots: list of (title, policy_map, values_map)
    Click Next/Prev (or use keyboard: Right/N/Space, Left/P/Backspace).
    """
    fig, ax = plt.subplots(figsize=(5, 4))
    plt.subplots_adjust(bottom=0.18)

    def render(i):
        title, pi, V = snapshots[i]
        draw_grid(ax, mdp, pi, V, title=f"{title}  [{i+1}/{len(snapshots)}]")
        fig.canvas.draw_idle()

    idx = 0
    # buttons
    ax_prev = plt.axes([0.25, 0.04, 0.12, 0.07])
    ax_next = plt.axes([0.39, 0.04, 0.12, 0.07])
    ax_reset = plt.axes([0.53, 0.04, 0.12, 0.07])
    ax_close = plt.axes([0.67, 0.04, 0.12, 0.07])

    btn_prev = Button(ax_prev, "Prev")
    btn_next = Button(ax_next, "Next")
    btn_reset = Button(ax_reset, "Reset")
    btn_close = Button(ax_close, "Close")

    def on_next(event):
        nonlocal idx
        if idx < len(snapshots) - 1:
            idx += 1
            render(idx)

    def on_prev(event):
        nonlocal idx
        if idx > 0:
            idx -= 1
            render(idx)

    def on_reset(event):
        nonlocal idx
        idx = 0
        render(idx)

    def on_close(event):
        if save_path:
            fig.savefig(save_path, dpi=150, bbox_inches="tight")
        plt.close(fig)

    btn_next.on_clicked(on_next)
    btn_prev.on_clicked(on_prev)
    btn_reset.on_clicked(on_reset)
    btn_close.on_clicked(on_close)

    # keyboard shortcuts
    def on_key(event):
        if event.key in ("right", "n", " "):
            on_next(event)
        elif event.key in ("left", "p", "backspace"):
            on_prev(event)
        elif event.key in ("r",):
            on_reset(event)
        elif event.key in ("escape", "q"):
            on_close(event)

    fig.canvas.mpl_connect("key_press_event", on_key)

    render(idx)
    plt.show()

# Legacy simple plots kept for completeness
def plot_value_function(value_function, title="Value Function"):
    states = list(value_function.keys())
    values = [value_function[state] for state in states]
    plt.figure(figsize=(10, 6))
    plt.bar(range(len(states)), values, color='blue')
    plt.xlabel('States'); plt.ylabel('Value'); plt.title(title); plt.grid(True); plt.show()

def plot_policy(policy, title="Policy"):
    states = list(policy.keys())
    actions = [policy[state] for state in states]
    plt.figure(figsize=(10, 6))
    plt.bar(range(len(states)), range(len(actions)), color='green')
    plt.xlabel('States'); plt.ylabel('Action idx'); plt.title(title); plt.grid(True); plt.show()